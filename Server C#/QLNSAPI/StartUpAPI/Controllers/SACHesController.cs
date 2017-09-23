using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using StartUpAPI.Models;
using System.Threading.Tasks;
using System.Web;
using System.Text;
using System.IO;
using System.Drawing;
using System.Drawing.Imaging;
using System.Net.Http.Headers;

namespace StartUpAPI.Controllers
{
    public class SACHesController : ApiController
    {
        private Model1 db = new Model1();

        // GET: api/SACHes
        public IQueryable<SACH> GetSACHes()
        {
            return db.SACHes.Where(s=>s.delflag == 0); 
        }

        // GET: api/GetSACHesHot
        public IQueryable<SACH> GetSACHesHot()
        {
            return db.SACHes.OrderBy(s=>s.ngayxuatban); 
        }

        // GET: api/SACHes/5
        [ResponseType(typeof(SACH))]
        [Route("api/SACHes/GetSACH/{id}")]
        public IHttpActionResult GetSACH(string id)
        {
            SACH sACH = db.SACHes.Where(s => s.masach == id).Single();
            if (sACH == null)
            {
                return NotFound();
            }

            return Ok(sACH);
        }

        // PUT: api/SACHes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutSACH(string id, SACH sACH)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != sACH.masach)
            {
                return BadRequest();
            }

            db.Entry(sACH).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SACHExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/SACHes
        [ResponseType(typeof(SACH))]
        public IHttpActionResult PostSACH(SACH sACH)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.SACHes.Add(sACH);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (SACHExists(sACH.masach))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = sACH.masach }, sACH);
        }

        // DELETE: api/SACHes/5
        [ResponseType(typeof(SACH))]
        public IHttpActionResult DeleteSACH(string id)
        {
            SACH sACH = db.SACHes.Find(id);
            if (sACH == null)
            {
                return NotFound();
            }

            db.SACHes.Remove(sACH);
            db.SaveChanges();

            return Ok(sACH);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool SACHExists(string id)
        {
            return db.SACHes.Count(e => e.masach == id) > 0;
        }

        [HttpPost]
        public async Task<HttpResponseMessage> PostSACHImage()
        {
            if (!Request.Content.IsMimeMultipartContent())
            {
                throw new HttpResponseException(HttpStatusCode.UnsupportedMediaType);
            }
            if (!System.IO.Directory.Exists(HttpContext.Current.Server.MapPath("~/Images/")))
            {
                System.IO.Directory.CreateDirectory(HttpContext.Current.Server.MapPath("~/Images/"));
            }

            string root = HttpContext.Current.Server.MapPath("~/Images/");
            var provider = new MultipartFormDataStreamProvider(root);

            try
            {
                StringBuilder sb = new StringBuilder();

                await Request.Content.ReadAsMultipartAsync(provider);

                foreach (var key in provider.FormData.AllKeys)
                {
                    foreach (var val in provider.FormData.GetValues(key))
                    {
                        using (StreamWriter w = File.AppendText(root + "log.txt"))
                        {
                            Log(key + val, w);
                        }
                        sb.Append(string.Format("{0}: {1}\n", key, val));

                    }
                }


                foreach (var fileData in provider.FileData)
                {
                    if (string.IsNullOrEmpty(fileData.Headers.ContentDisposition.FileName))
                    {
                        return Request.CreateResponse(HttpStatusCode.NotAcceptable, "This request is not properly formatted");
                    }
                    string fileName = fileData.Headers.ContentDisposition.FileName;
                    if (fileName.StartsWith("\"") && fileName.EndsWith("\""))
                    {
                        fileName = fileName.Trim('"');
                    }
                    if (fileName.Contains(@"/") || fileName.Contains(@"\"))
                    {
                        fileName = Path.GetFileName(fileName);
                    }
                    if (File.Exists(Path.Combine(root, fileName)))
                    {
                        File.Delete(Path.Combine(root, fileName));
                    }
                    File.Move(fileData.LocalFileName, Path.Combine(root, fileName));
                }
                return new HttpResponseMessage()
                {
                    Content = new StringContent(sb.ToString())
                };
            }
            catch (System.Exception e)
            {
                using (StreamWriter w = File.AppendText(root + "log.txt"))
                {
                    Log(e.Message, w);
                }
                return Request.CreateErrorResponse(HttpStatusCode.InternalServerError, e);
            }
        }

        [HttpGet]
        public HttpResponseMessage GetSACHImage(string id)
        {
            HttpResponseMessage httpResponseMessage = new HttpResponseMessage();

            // Photo.Resize is a static method to resize the image
            SACH ev = db.SACHes.Find(id);
            string root = ev.anhbia;
            var result = new HttpResponseMessage(HttpStatusCode.OK);
            FileStream fileStream = new FileStream(root, FileMode.Open);
            Image image = Image.FromStream(fileStream);
            MemoryStream memoryStream = new MemoryStream();
            image.Save(memoryStream, ImageFormat.Jpeg);
            var byteArrayContent = new ByteArrayContent(memoryStream.ToArray());
            byteArrayContent.Headers.ContentType = new MediaTypeHeaderValue("image/jpeg");
            result.Content = byteArrayContent;
            memoryStream.Close();
            fileStream.Close();
            return result;
        }

        public void Log(string logMessage, TextWriter w)
        {
            w.Write("Log PostImage : ");
            w.WriteLine("{0} {1}", DateTime.Now.ToLongTimeString(),
                DateTime.Now.ToLongDateString());
            w.WriteLine("Error             : {0}", logMessage);
            w.WriteLine("-------------------------------");
        }
    }
}
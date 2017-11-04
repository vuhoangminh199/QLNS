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

namespace StartUpAPI.Controllers
{
    public class CT_DATHANGsController : ApiController
    {
        private Model1 db = new Model1();

        // GET: api/CT_DATHANGs
        public IQueryable<CT_DATHANG> GetCT_DATHANG()
        {
            return db.CT_DATHANG;
        }

        // GET: api/CT_DATHANGs/5
        [ResponseType(typeof(CT_DATHANG))]
        public IHttpActionResult GetCT_DATHANG(string id)
        {
            CT_DATHANG cT_DATHANG = db.CT_DATHANG.Find(id);
            if (cT_DATHANG == null)
            {
                return NotFound();
            }

            return Ok(cT_DATHANG);
        }

        // PUT: api/CT_DATHANGs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutCT_DATHANG(string id, CT_DATHANG cT_DATHANG)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != cT_DATHANG.madathang)
            {
                return BadRequest();
            }

            db.Entry(cT_DATHANG).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CT_DATHANGExists(id))
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

        // POST: api/CT_DATHANGs
        [ResponseType(typeof(CT_DATHANG))]
        public IHttpActionResult PostCT_DATHANG(CT_DATHANG cT_DATHANG)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.CT_DATHANG.Add(cT_DATHANG);
            SACH sach = db.SACHes.Find(cT_DATHANG.masach);
            sach.soluongton = sach.soluongton - cT_DATHANG.soluongdat;

            db.Entry(sach).State = EntityState.Modified;
            db.SaveChanges();
            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (CT_DATHANGExists(cT_DATHANG.madathang))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = cT_DATHANG.madathang }, cT_DATHANG);
        }

        // DELETE: api/CT_DATHANGs/5
        [ResponseType(typeof(CT_DATHANG))]
        public IHttpActionResult DeleteCT_DATHANG(string id)
        {
            CT_DATHANG cT_DATHANG = db.CT_DATHANG.Find(id);
            if (cT_DATHANG == null)
            {
                return NotFound();
            }

            db.CT_DATHANG.Remove(cT_DATHANG);
            db.SaveChanges();

            return Ok(cT_DATHANG);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool CT_DATHANGExists(string id)
        {
            return db.CT_DATHANG.Count(e => e.madathang == id) > 0;
        }
    }
}
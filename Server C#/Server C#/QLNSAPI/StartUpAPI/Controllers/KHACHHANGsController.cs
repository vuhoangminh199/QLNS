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
    public class KHACHHANGsController : ApiController
    {
        private Model1 db = new Model1();

        // GET: api/KHACHHANGs
        public IQueryable<KHACHHANG> GetKHACHHANGs()
        {
            return db.KHACHHANGs;
        }

        //login
        [ResponseType(typeof(KHACHHANG))]
        [Route("api/KHACHHANGs/Login/{phone}/{pass}")]
        public IHttpActionResult GetUserLogin(string phone, string pass)
        {
            KHACHHANG KHACHHANG = db.KHACHHANGs.Where(s => ((s.sodienthoai == phone) && (s.matkhaukh == pass))).Single();
            if (KHACHHANG == null)
            {
                return NotFound();
            }

            return Ok(KHACHHANG);
        }

        // GET: api/KHACHHANGs/5
        [ResponseType(typeof(KHACHHANG))]
        public IHttpActionResult GetKHACHHANG(string id)
        {
            KHACHHANG kHACHHANG = db.KHACHHANGs.Find(id);
            if (kHACHHANG == null)
            {
                return NotFound();
            }

            return Ok(kHACHHANG);
        }

        // PUT: api/KHACHHANGs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutKHACHHANG(string id, KHACHHANG kHACHHANG)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != kHACHHANG.makh)
            {
                return BadRequest();
            }

            db.Entry(kHACHHANG).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!KHACHHANGExists(id))
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

        // POST: api/KHACHHANGs
        [ResponseType(typeof(KHACHHANG))]
        public IHttpActionResult PostKHACHHANG(KHACHHANG kHACHHANG)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            List<KHACHHANG> listuser = db.KHACHHANGs.ToList();
            String makh = "KH" + (listuser.Count + 1);
            kHACHHANG.makh = makh;
            db.KHACHHANGs.Add(kHACHHANG);
            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (KHACHHANGExists(kHACHHANG.makh))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = kHACHHANG.makh }, kHACHHANG);
        }

        // DELETE: api/KHACHHANGs/5
        [ResponseType(typeof(KHACHHANG))]
        public IHttpActionResult DeleteKHACHHANG(string id)
        {
            KHACHHANG kHACHHANG = db.KHACHHANGs.Find(id);
            if (kHACHHANG == null)
            {
                return NotFound();
            }

            db.KHACHHANGs.Remove(kHACHHANG);
            db.SaveChanges();

            return Ok(kHACHHANG);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool KHACHHANGExists(string id)
        {
            return db.KHACHHANGs.Count(e => e.makh == id) > 0;
        }
    }
}
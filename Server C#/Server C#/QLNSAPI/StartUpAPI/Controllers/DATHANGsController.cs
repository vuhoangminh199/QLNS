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
    public class DATHANGsController : ApiController
    {
        private Model1 db = new Model1();

        // GET: api/DATHANGs
        public IQueryable<DATHANG> GetDATHANGs()
        {
            return db.DATHANGs;
        }

        // GET: api/DATHANGs/5
        [ResponseType(typeof(DATHANG))]
        public IHttpActionResult GetDATHANG(string id)
        {
            DATHANG dATHANG = db.DATHANGs.Find(id);
            if (dATHANG == null)
            {
                return NotFound();
            }

            return Ok(dATHANG);
        }

        // PUT: api/DATHANGs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDATHANG(string id, DATHANG dATHANG)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != dATHANG.madathang)
            {
                return BadRequest();
            }

            db.Entry(dATHANG).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DATHANGExists(id))
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

        // POST: api/DATHANGs
        [ResponseType(typeof(DATHANG))]
        public IHttpActionResult PostDATHANGs(DATHANG dATHANG)
        {
           
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            
            dATHANG.madathang = " ";
            db.DATHANGs.Add(dATHANG);
            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (DATHANGExists(dATHANG.madathang))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = dATHANG.madathang }, dATHANG);
        }

        // DELETE: api/DATHANGs/5
        [ResponseType(typeof(DATHANG))]
        public IHttpActionResult DeleteDATHANG(string id)
        {
            DATHANG dATHANG = db.DATHANGs.Find(id);
            if (dATHANG == null)
            {
                return NotFound();
            }

            db.DATHANGs.Remove(dATHANG);
            db.SaveChanges();

            return Ok(dATHANG);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DATHANGExists(string id)
        {
            return db.DATHANGs.Count(e => e.madathang == id) > 0;
        }
    }
}
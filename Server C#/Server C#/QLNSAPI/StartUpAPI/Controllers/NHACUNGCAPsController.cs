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
    public class NHACUNGCAPsController : ApiController
    {
        private Model1 db = new Model1();

        // GET: api/NHACUNGCAPs
        public IQueryable<NHACUNGCAP> GetNHACUNGCAPs()
        {
            return db.NHACUNGCAPs;
        }

        // GET: api/NHACUNGCAPs/5
        [ResponseType(typeof(NHACUNGCAP))]
        public IHttpActionResult GetNHACUNGCAP(string id)
        {
            NHACUNGCAP nHACUNGCAP = db.NHACUNGCAPs.Find(id);
            if (nHACUNGCAP == null)
            {
                return NotFound();
            }

            return Ok(nHACUNGCAP);
        }

        // PUT: api/NHACUNGCAPs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutNHACUNGCAP(string id, NHACUNGCAP nHACUNGCAP)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != nHACUNGCAP.mancc)
            {
                return BadRequest();
            }

            db.Entry(nHACUNGCAP).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!NHACUNGCAPExists(id))
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

        // POST: api/NHACUNGCAPs
        [ResponseType(typeof(NHACUNGCAP))]
        public IHttpActionResult PostNHACUNGCAP(NHACUNGCAP nHACUNGCAP)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.NHACUNGCAPs.Add(nHACUNGCAP);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (NHACUNGCAPExists(nHACUNGCAP.mancc))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = nHACUNGCAP.mancc }, nHACUNGCAP);
        }

        // DELETE: api/NHACUNGCAPs/5
        [ResponseType(typeof(NHACUNGCAP))]
        public IHttpActionResult DeleteNHACUNGCAP(string id)
        {
            NHACUNGCAP nHACUNGCAP = db.NHACUNGCAPs.Find(id);
            if (nHACUNGCAP == null)
            {
                return NotFound();
            }

            db.NHACUNGCAPs.Remove(nHACUNGCAP);
            db.SaveChanges();

            return Ok(nHACUNGCAP);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool NHACUNGCAPExists(string id)
        {
            return db.NHACUNGCAPs.Count(e => e.mancc == id) > 0;
        }
    }
}
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
    public class THELOAIsController : ApiController
    {
        private Model1 db = new Model1();

        // GET: api/THELOAIs
        public IQueryable<THELOAI> GetTHELOAIs()
        {
            return db.THELOAIs;
        }

        // GET: api/THELOAIs/5
        [ResponseType(typeof(THELOAI))]
        public IHttpActionResult GetTHELOAI(string id)
        {
            THELOAI tHELOAI = db.THELOAIs.Find(id);
            if (tHELOAI == null)
            {
                return NotFound();
            }

            return Ok(tHELOAI);
        }

        // PUT: api/THELOAIs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTHELOAI(string id, THELOAI tHELOAI)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != tHELOAI.matheloai)
            {
                return BadRequest();
            }

            db.Entry(tHELOAI).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!THELOAIExists(id))
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

        // POST: api/THELOAIs
        [ResponseType(typeof(THELOAI))]
        public IHttpActionResult PostTHELOAI(THELOAI tHELOAI)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.THELOAIs.Add(tHELOAI);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (THELOAIExists(tHELOAI.matheloai))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = tHELOAI.matheloai }, tHELOAI);
        }

        // DELETE: api/THELOAIs/5
        [ResponseType(typeof(THELOAI))]
        public IHttpActionResult DeleteTHELOAI(string id)
        {
            THELOAI tHELOAI = db.THELOAIs.Find(id);
            if (tHELOAI == null)
            {
                return NotFound();
            }

            db.THELOAIs.Remove(tHELOAI);
            db.SaveChanges();

            return Ok(tHELOAI);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool THELOAIExists(string id)
        {
            return db.THELOAIs.Count(e => e.matheloai == id) > 0;
        }
    }
}
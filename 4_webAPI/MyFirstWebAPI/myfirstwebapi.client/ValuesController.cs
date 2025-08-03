using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;

namespace MyFirstWebAPI.Controllers
{
	[ApiController]
	[Route("api/[controller]")]
	public class ValuesController : ControllerBase
	{
		// In-memory data store
		private static List<string> values = new List<string> { "value1", "value2" };

		// GET: api/values
		[HttpGet]
		[ProducesResponseType(StatusCodes.Status200OK)]
		public ActionResult<IEnumerable<string>> Get()
		{
			return Ok(values);
		}

		// GET: api/values/5
		[HttpGet("{id}")]
		[ActionName("GetById")]
		[ProducesResponseType(StatusCodes.Status200OK)]
		[ProducesResponseType(StatusCodes.Status404NotFound)]
		public ActionResult<string> Get(int id)
		{
			if (id < 0 || id >= values.Count)
				return NotFound();

			return Ok(values[id]);
		}

		// POST: api/values
		[HttpPost]
		[ProducesResponseType(StatusCodes.Status201Created)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		public ActionResult Post([FromBody] string value)
		{
			if (string.IsNullOrWhiteSpace(value))
				return BadRequest("Value cannot be empty.");

			values.Add(value);

			// Return 201 Created with location header pointing to newly created resource
			return CreatedAtAction(nameof(Get), new { id = values.Count - 1 }, value);
		}

		// PUT: api/values/5
		[HttpPut("{id}")]
		[ProducesResponseType(StatusCodes.Status204NoContent)]
		[ProducesResponseType(StatusCodes.Status400BadRequest)]
		[ProducesResponseType(StatusCodes.Status404NotFound)]
		public ActionResult Put(int id, [FromBody] string value)
		{
			if (string.IsNullOrWhiteSpace(value))
				return BadRequest("Value cannot be empty.");

			if (id < 0 || id >= values.Count)
				return NotFound();

			values[id] = value;

			return NoContent(); // 204 No Content
		}

		// DELETE: api/values/5
		[HttpDelete("{id}")]
		[ProducesResponseType(StatusCodes.Status204NoContent)]
		[ProducesResponseType(StatusCodes.Status404NotFound)]
		public ActionResult Delete(int id)
		{
			if (id < 0 || id >= values.Count)
				return NotFound();

			values.RemoveAt(id);

			return NoContent();
		}
	}
}

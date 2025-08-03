using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using MyFirstWebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace MyFirstWebAPI.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    [Authorize(Roles = "Admin,POC")]  // Only users with role Admin or POC can access
    public class EmployeeController : ControllerBase
    {
        // Hardcoded list of employees for demo purposes
        private static List<Employee> _employees = new List<Employee>
        {
            new Employee
            {
                Id = 1,
                Name = "John",
                Salary = 5000,
                Permanent = true,
                Department = new Department { Id = 101, Name = "HR" },
                Skills = new List<Skill> { new Skill { Id = 1, Name = "C#" } },
                DateOfBirth = new DateTime(1990, 1, 1)
            },
            new Employee
            {
                Id = 2,
                Name = "Jane",
                Salary = 6000,
                Permanent = false,
                Department = new Department { Id = 102, Name = "Finance" },
                Skills = new List<Skill> { new Skill { Id = 2, Name = "Java" } },
                DateOfBirth = new DateTime(1992, 2, 2)
            }
        };

        // GET: api/Employee
        [HttpGet]
        [ProducesResponseType(typeof(List<Employee>), 200)]
        public ActionResult<List<Employee>> Get()
        {
            return Ok(_employees);
        }

        // GET: api/Employee/1
        [HttpGet("{id}")]
        [ProducesResponseType(typeof(Employee), 200)]
        [ProducesResponseType(404)]
        public ActionResult<Employee> GetById(int id)
        {
            var emp = _employees.FirstOrDefault(e => e.Id == id);
            if (emp == null)
                return NotFound();

            return Ok(emp);
        }

        // POST: api/Employee
        [HttpPost]
        [ProducesResponseType(typeof(Employee), 201)]
        public ActionResult<Employee> Post([FromBody] Employee employee)
        {
            employee.Id = _employees.Max(e => e.Id) + 1;
            _employees.Add(employee);
            return CreatedAtAction(nameof(GetById), new { id = employee.Id }, employee);
        }

        // PUT: api/Employee/1
        [HttpPut("{id}")]
        [ProducesResponseType(typeof(Employee), 200)]
        [ProducesResponseType(400)]
        public ActionResult<Employee> Put(int id, [FromBody] Employee updatedEmployee)
        {
            if (id <= 0)
                return BadRequest("Invalid employee id");

            var existing = _employees.FirstOrDefault(e => e.Id == id);
            if (existing == null)
                return BadRequest("Invalid employee id");

            // Update fields
            existing.Name = updatedEmployee.Name;
            existing.Salary = updatedEmployee.Salary;
            existing.Permanent = updatedEmployee.Permanent;
            existing.Department = updatedEmployee.Department;
            existing.Skills = updatedEmployee.Skills;
            existing.DateOfBirth = updatedEmployee.DateOfBirth;

            return Ok(existing);
        }

        // DELETE: api/Employee/1
        [HttpDelete("{id}")]
        [ProducesResponseType(204)]
        [ProducesResponseType(400)]
        public IActionResult Delete(int id)
        {
            var emp = _employees.FirstOrDefault(e => e.Id == id);
            if (emp == null)
                return BadRequest("Employee not found");

            _employees.Remove(emp);
            return NoContent();
        }

        // Optional endpoint to throw exception and test exception filter (if implemented)
        [HttpGet("throw")]
        [ProducesResponseType(500)]
        public IActionResult ThrowException()
        {
            throw new Exception("This is a test exception for filter logging");
        }
    }
}

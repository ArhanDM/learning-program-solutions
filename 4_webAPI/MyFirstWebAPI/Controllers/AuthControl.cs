using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Microsoft.AspNetCore.Authorization;


[ApiController]
[Route("api/[controller]")]
[AllowAnonymous]
public class AuthController : ControllerBase
{
	private string GenerateJSONWebToken(int userId, string userRole)
	{
		var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes("mysuperdupersecretkeythatismorethan32byteslong"));


		var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);

		var claims = new List<Claim>
	{
		new Claim(ClaimTypes.Role, userRole),
		new Claim("UserId", userId.ToString())
	};

		var token = new JwtSecurityToken(
					issuer: "mySystem",
					audience: "myUsers",
					claims: claims,
					expires: DateTime.Now.AddMinutes(2), // <-- Set expiry to 2 minutes
					signingCredentials: credentials);

		return new JwtSecurityTokenHandler().WriteToken(token);
	}


	[HttpGet("token")]
	public IActionResult GetToken(int userId = 1, string role = "Admin")
	{
		var tokenString = GenerateJSONWebToken(userId, role);
		return Ok(new { token = tokenString });
	}
}

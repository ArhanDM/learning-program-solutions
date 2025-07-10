using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using System;
using System.IO;

namespace MyFirstWebAPI.Filters
{
	public class CustomExceptionFilter : IExceptionFilter
	{
		public void OnException(ExceptionContext context)
		{
			var exception = context.Exception;

			// Log exception to file (for demo, logs to same folder as app)
			var logPath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "errors.log");
			var logMessage = $"{DateTime.Now}: {exception.Message} - {exception.StackTrace}\n";
			File.AppendAllText(logPath, logMessage);

			// Set result to Internal Server Error with message
			context.Result = new ObjectResult(new { error = "Internal Server Error", message = exception.Message })
			{
				StatusCode = 500
			};

			context.ExceptionHandled = true;
		}
	}
}

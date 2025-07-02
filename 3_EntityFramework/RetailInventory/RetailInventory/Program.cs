using System;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RetailInventory.Data;     // Change to your actual namespace
using RetailInventory.Models;   // Change to your actual namespace

class Program
{
    static async Task Main(string[] args)
    {
        using var context = new AppDbContext();

        // Insert initial data (Lab 4) - Only if database is empty
        if (await context.Categories.CountAsync() == 0 && await context.Products.CountAsync() == 0)
        {
            var electronics = new Category { Name = "Electronics" };
            var groceries = new Category { Name = "Groceries" };

            await context.Categories.AddRangeAsync(electronics, groceries);

            var product1 = new Product { Name = "Laptop", Price = 75000, Category = electronics };
            var product2 = new Product { Name = "Rice Bag", Price = 1200, Category = groceries };

            await context.Products.AddRangeAsync(product1, product2);

            await context.SaveChangesAsync();

            Console.WriteLine("Initial data inserted successfully!");
        }
        else
        {
            Console.WriteLine("Data already exists. Skipping data insertion.");
        }

        // Retrieve and display all products (Lab 5)
        var products = await context.Products.ToListAsync();
        Console.WriteLine("\nAll Products:");
        foreach (var p in products)
        {
            Console.WriteLine($"{p.Name} - ₹{p.Price}");
        }

        // Find product by ID = 1
        var productById = await context.Products.FindAsync(1);
        Console.WriteLine($"\nFound by ID 1: {productById?.Name ?? "No product found"}");

        // First product with price > 50000
        var expensiveProduct = await context.Products.FirstOrDefaultAsync(p => p.Price > 50000);
        Console.WriteLine($"\nFirst Expensive Product (> ₹50000): {expensiveProduct?.Name ?? "No product found"}");

        Console.WriteLine("\nPress any key to exit...");
        Console.ReadKey();
    }
}

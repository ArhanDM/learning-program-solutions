using System.Collections.Generic;
using RetailInventory.Models;

public class Category
{
    public int Id { get; set; }
    public string Name { get; set; } = string.Empty;             // Initialize with empty string
    public List<Product> Products { get; set; } = new List<Product>();  // Initialize with empty list
}

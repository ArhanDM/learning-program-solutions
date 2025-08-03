namespace RetailInventory.Models
{
    public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; } = string.Empty;   // Initialize with empty string
        public decimal Price { get; set; }

        public int CategoryId { get; set; }
        public Category Category { get; set; } = null!;    // Null-forgiving operator (!) tells compiler it's set elsewhere
    }
}

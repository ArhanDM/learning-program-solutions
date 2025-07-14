using Confluent.Kafka;

var config = new ProducerConfig
{
    BootstrapServers = "localhost:9092"
};

using var producer = new ProducerBuilder<Null, string>(config).Build();

Console.WriteLine("Chat Producer started. Type your messages:");

while (true)
{
    string? message = Console.ReadLine();
    if (!string.IsNullOrWhiteSpace(message))
    {
        await producer.ProduceAsync("chat-app", new Message<Null, string> { Value = message });
        Console.WriteLine($"[Sent]: {message}");
    }
}

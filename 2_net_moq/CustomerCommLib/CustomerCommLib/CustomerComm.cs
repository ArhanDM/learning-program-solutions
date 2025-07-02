namespace CustomerCommLib
{
    public class CustomerComm
    {
        private IMailSender _mailSender;

        public CustomerComm(IMailSender mailSender)
        {
            _mailSender = mailSender;
        }

        public bool SendMailToCustomer()
        {
            // Imagine this is dynamic data from a transaction
            string toAddress = "cust123@abc.com";
            string message = "Some Message";

            return _mailSender.SendMail(toAddress, message);
        }
    }
}

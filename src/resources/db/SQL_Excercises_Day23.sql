--SELECT * FROM customers 
--SELECT ALL non USA customers
--SELECT ONLY German customers
--SELECT employees (different table) who are sales agents
--SEELCT unique biling countries from invoice table
SELECT * FROM customers
Where Country !='USA';

SELECT *FROM customers 
Where Country ='Germany';

SELECT * FROM employees
WHERE title='Sales Support Agent';

SELECT DISTINCT BillingCountry  From invoices;







SELECT * FROM tracks t
ORDER BY Name DESC
LIMIT 25
OFFSET 10;

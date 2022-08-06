# ennea

availabel API's



1)	API to accept a CSV file and ingest the data into a db. You can take it that a new csv added will be of the same format.
http://localhost:8080/scm/upload



2)	Given a supplier id or name, list all the products that the supplier has with stock.
http://localhost:8080/scm/product/stock?supplierName=ABC


3)	Accept a search param for the above filter based on the product name.
http://localhost:8080/scm/product/stock?productCode=123


4)	Accept a param for the above api, or create a new endpoint to only list out products that didn’t yet expire for that supplier or list of suppliers.
http://localhost:8080/scm/product/nonExpired?supplierName=ABC




5)	Make the above api’s pageable.
http://localhost:8080/scm/product/nonExpired?supplierName=ABC&pageNo=1&pageSize=100


DB Model

Product ----------------------Supplier has many to many mapping so new table with those primary keys will be created as ProductSupplier 

<h1>Project Name: The Forging Catalog</h1>
<p><strong>Description:</strong> It is a REST API that manages the simulator's three main menus: object creation, purchase, and sale. The information is handled in JSON format.</p>

<h2>Technologies Used:</h2>
<ul>
  <li><strong>Programming Language:</strong> Java</li>
  <li><strong>Libraries/Frameworks:</strong></li>
  <ul>
    <li><strong>Spring Boot:</strong> Used for the development of the REST API.</li>
    <li><strong>MapStruct:</strong> Design pattern used for conversion between different types of objects.</li>
  </ul>
  <li><strong>Database:</strong> PostgreSQL (relational)</li>
  <li><strong>Database Connection:</strong> JPA Hibernate (Java Persistence API)</li>
  <li><strong>Architecture:</strong> A domain-driven layered architecture is used. This implies a code structure that clearly separates responsibilities into different layers, such as the presentation layer, service layer, and data access layer, with a focus on the domain of the problem being modeled.</li>
</ul>

<h2>Project Functionality:</h2>
<p>The project is responsible for managing the three main menus of the virtual blacksmith simulator: object creation, purchase, and sale. Data is exchanged in JSON format through the REST API.</p>

<h2>API Documentation</h2>
<p>This API provides endpoints for managing acquisitions, sales, and warehouse in an inventory management system.</p>

<h3>Acquisition Controller</h3>
<p>The AcquisitionController handles operations related to product acquisitions.</p>

<h4>Endpoints</h4>

<ul>
  <li><strong>Get Random Peddler</strong></li>
  <ul>
    <li><strong>URL:</strong> /acquisitions/random-peddler</li>
    <li><strong>HTTP Method:</strong> GET</li>
    <li><strong>Description:</strong> Returns a random peddler.</li>
    <li><strong>Response:</strong> Returns a PeddlerDTO object.</li>
  </ul>

  <li><strong>Get Peddler Products</strong></li>
  <ul>
    <li><strong>URL:</strong> /acquisitions/peddler-products/{peddlerId}</li>
    <li><strong>HTTP Method:</strong> GET</li>
    <li><strong>Description:</strong> Returns products of a specific peddler.</li>
    <li><strong>Path Parameters:</strong> {peddlerId} (Integer)</li>
    <li><strong>Response:</strong> Returns a list of AcquisitionDTO objects.</li>
  </ul>

  <li><strong>Get Warehouse Products</strong></li>
  <ul>
    <li><strong>URL:</strong> /acquisitions/warehouse-products</li>
    <li><strong>HTTP Method:</strong> GET</li>
    <li><strong>Description:</strong> Returns warehouse products.</li>
    <li><strong>Response:</strong> Returns a list of WarehouseDTO objects.</li>
  </ul>

  <li><strong>Increase Stock</strong></li>
  <ul>
    <li><strong>URL:</strong> /acquisitions/increase-stock/{quantityToAddAcquisition}/{productIdAcquisition}/{peddlerId}/{quantityToAddWarehouse}/{productIdWarehouse}</li>
    <li><strong>HTTP Method:</strong> POST</li>
    <li><strong>Description:</strong> Increases the stock of a product in both acquisitions and the warehouse.</li>
    <li><strong>Path Parameters:</strong> {quantityToAddAcquisition} (Integer), {productIdAcquisition} (RequestParam Integer), {peddlerId} (RequestParam Integer), {quantityToAddWarehouse} (RequestParam Integer), {productIdWarehouse} (RequestParam Integer)</li>
    <li><strong>Response:</strong> Returns an HTTP status code indicating the success or failure of the operation.</li>
  </ul>
</ul>

<h3>Sales Controller</h3>
<p>The SalesController handles operations related to product sales.</p>

<h4>Endpoints</h4>

<!-- Sales Controller endpoints -->

<h3>Warehouse Controller</h3>
<p>The WarehouseController handles operations related to product warehouse.</p>

<h4>Endpoints</h4>

<!-- Warehouse Controller endpoints -->

</html>

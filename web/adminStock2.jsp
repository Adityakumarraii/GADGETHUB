<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Bootstrap demo</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
  </head>
  <body>
       <jsp:include page="header.jsp"/>
    <div class="text-primary text-center h3 mt-3 mb-3">Product Stock</div>
    <div class="container-fluid">
      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Product Image</th>
              <th>Product ID</th>
              <th>Product Name</th>
              <th>Price</th>
              <th>Sold Qty</th>
              <th>Stock Qty</th>
              <th colspan="2" class="text-center">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <img src="mobile.jfif" alt="" width="100px" height="100px" />
              </td>
              <td>12345</td>
              <td>IPhone</td>
              <td>50000</td>
              <td>10</td>
              <td>20</td>
              <td>
                <form action="">
                  <button type="submit" class="btn btn-primary">Update</button>
                </form>
              </td>
              <td>
                <form action="">
                    <button type="submit" class="btn btn-danger">Remove</button>
                </form>
              </td>
            </tr>
            <tr>
                <td colspan="8" class="text-center">No items available</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
     <jsp:include page="footer.jsp"/>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>

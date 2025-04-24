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
    <link rel="stylesheet" href="styles.css" />
  </head>
  <body>
      <jsp:include page="header.jsp"/>
    <div class="conatiner mt-5 mb-5">
      <div class="row justify-content-center">
        <form action="#" class="col-md-6 myform">
          <div class="text-center">
            <img src="payment.jfif" alt="" height="100px" width="100px" />
            <h2 class="text-primary">Payment Details</h2>
          </div>
          <div class="row mt-3">
            <div class="form-group col-md-12">
              <label for="card_holder_name">Name of Card Holder</label>
              <input type="text" id="card_holder_name" class="form-control" />
            </div>
          </div>
          <div class="row mt-3">
            <div class="form-group col-md-12">
              <label for="card_number">Credit Card Number</label>
              <input
                type="text"
                id="card_number"
                class="form-control"
                placeholder="1234-1234-1234"
              />
            </div>
          </div>

          <div class="row mt-3">
            <div class="col-md-6 form-group">
              <label for="expiry_month">Expiry Month</label>
              <input
                type="number"
                id="expiry_month"
                class="form-control"
                min="1"
                max="12"
              />
            </div>
            <div class="col-md-6 form-group">
              <label for="expiry_year">Expiry Year</label>
              <input type="number" id="expiry_year" class="form-control" />
            </div>
          </div>

          <div class="row mt-3 mb-3">
            <div class="col-md-6 form-group">
              <label for="cvv">Card CVV</label>
              <input type="number" class="form-control" id="cvv" />
            </div>
            <div class="col-md-6 form-group">
              <label for="">&nbsp;</label>
              <button type="button" class="btn btn-warning form-control">
                Pay Rs: 20000
              </button>
            </div>
          </div>
        </form>
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
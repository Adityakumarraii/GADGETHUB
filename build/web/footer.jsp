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
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
      integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
   
  </head>
  <body>
    <div class="container-fluid bg-primary text-white p-3">
      <div class="container">
        <h2 class="text-center">Contact</h2>
        <p class="text-center">We love our Customer!</p>
        <div class="row">
          <div class="col-md-4">
            <p><i class="fa-solid fa-phone"></i> Phone : +91 9630391085</p>
            <p>
              <i class="fa-solid fa-envelope"></i> Email : kumarraiaditya476@gmail.com
            </p>
            <p><i class="fa-solid fa-signs-post"></i> Postal Code : 462022</p>
          </div>

          <div class="col-md-8">
            <form action="#">
              <div class="row">
                <div class="col-sm-6 form-group mt-1">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="name"
                    required
                  />
                </div>
                <div class="col-sm-6 form-group mt-1">
                  <input
                    type="email"
                    class="form-control"
                    placeholder="email"
                    required
                  />
                </div>
              </div>

              <textarea
                  name=""
                  id=""
                  rows="5"
                  class="form-control mt-1"
                  placeholder="Enter your message.."
                ></textarea>

                <div class="row">
                    <div class="col-md-12 form-group mt-1">
                        <button type="button" class="btn btn-warning">send</button>
                    </div>
                </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
  </body>
<script>
(function(){if(!window.chatbase||window.chatbase("getState")!=="initialized"){window.chatbase=(...arguments)=>{if(!window.chatbase.q){window.chatbase.q=[]}window.chatbase.q.push(arguments)};window.chatbase=new Proxy(window.chatbase,{get(target,prop){if(prop==="q"){return target.q}return(...args)=>target(prop,...args)}})}const onLoad=function(){const script=document.createElement("script");script.src="https://www.chatbase.co/embed.min.js";script.id="S-pJB3Ve6-EGroGn0tXL_";script.domain="www.chatbase.co";document.body.appendChild(script)};if(document.readyState==="complete"){onLoad()}else{window.addEventListener("load",onLoad)}})();
</script> 
</html>

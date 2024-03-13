import React from 'react'

const Banner = () => {
  return (
    <section>
      <div class="text-center">
        <h1 class="display-5 fw-bold text-body-emphasis">Welcome to e-com App</h1>
        <div class="col-lg-6 mx-auto">
          <p class="lead mb-4">You can browse and manage Products and Categories here.</p>
          <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
            <button type="button" class="btn btn-primary btn-md px-4 gap-3">Browse Products</button>
          </div>
        </div>
      </div>
    </section>
  )
}

export default Banner;

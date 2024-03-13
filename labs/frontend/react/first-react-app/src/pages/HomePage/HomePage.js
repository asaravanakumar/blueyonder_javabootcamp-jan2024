import React from 'react'
import ProductPage from '../ProductsPage/ProductsPage1' // static data with props
// import ProductPage from '../ProductsPage/ProductsPage2' // static data with state
// import ProductPage from '../ProductsPage/ProductsPage3' // static data with state, events & hooks

import Banner from '../../components/Banner/Banner'

const HomePage = () => {
  return (
    <main className="text-center mt-5 pt-5" >
      {/* <p>Welcome to React JS Training!!!</p> */}
      <Banner/>

      <section>
        <ProductPage/>
      </section>
    </main>
  )
}

export default HomePage

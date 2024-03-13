// rafce = React Arrow Function Export Component

import React from 'react'
import MenuList from '../MenuList/MenuList';

const Footer = () => {
  const year = 2024;
  const companyName = 'BlueYonder';

  return (
    // <footer className="text-center">
    //   <hr/>
    //   <p>&copy; Copy Right 2024 | BlueYonder</p>
    // </footer>
      <footer class="bottom pt-3 mt-3">
        <ul class="nav justify-content-center border-bottom pb-1 mb-1">
          {/* <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Home</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Features</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Pricing</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">FAQs</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">About</a></li> */}
          <MenuList menuItem1="Home" menuItem2="Contact Us" menuItem3="FAQs" menuItem4="About Us"/>
        </ul> 
        <p class="text-center text-body-secondary">© {year} {companyName}</p>
      </footer>
  )
}

export default Footer

import React from 'react'
import Navbar from './../../components/Navbar1/Navbar'
import Home from './../../components/Home/Home'
import Footer from './../../components/Footer/Footer'
import Search from './../../components/Search/Search'
import Support from './../../components/Support/Support'
import Info from './../../components/Info/Info'
import Lounge from './../../components/Lounge/Lounge'
import Travelers from './../../components/Travelers/Travelers'
import Subscribers from './../../components/Subscribers/Subscribers'

const Welcome = () => {
  return (
    <div>
      <Navbar/>
      <Home/>
      <Search/>
      <Support/>
      <Info/>
      <Lounge/>
      <Travelers/>
      <Subscribers/>
      <Footer/>
    </div>
  )
}

export default Welcome

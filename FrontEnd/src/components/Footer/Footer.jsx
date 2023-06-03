import React,{useEffect} from 'react'
import Logo from '../../assets/images/logo.png'
import {TiSocialFacebook, TiSocialInstagram} from 'react-icons/ti'
import { AiFillYoutube, AiOutlineTwitter } from 'react-icons/ai'
import Aos from 'aos'
import 'aos/dist/aos.css'
const Footer = () => {
  // useEffect to set animation effect
  useEffect(()=>{
    Aos.init({duration: 2000})
  }, [])
  return (
    <div className='footer'>
      <div className="sectionContainer container grid">
        <div data-aos="fade-up" data-aos-duration='2500' className="gridOne">
          <div className="logoDiv">
            <img src={Logo} className='Logo' alt="" />
          </div>
          <p>Your min should be stronger than your feelings, fly!</p>
          <div className="socialIcon flex">
            <TiSocialFacebook className='icon'/>
            <AiOutlineTwitter className='icon'/>
            <AiFillYoutube className='icon'/>
            <TiSocialInstagram className='icon'/>

          </div>
        </div>

        <div data-aos="fade-up" data-aos-duration='2500' className="footerLinks">
          <span className="linkTitle">Information</span>
          <li>
            <a href="#">Home</a>
          </li>
          <li>
            <a href="#">Explore</a>
          </li>
          <li>
            <a href="#">Flight Status</a>
          </li>
          <li>
            <a href="#">Travel</a>
          </li>
          <li>
            <a href="#">Check-In</a>
          </li>
          <li>
            <a href="#">Manage your Booking</a>
          </li>
        </div>

        <div data-aos="fade-up" data-aos-duration='2500' className="footerLinks">
          <span className="linkTitle">Quick Guide</span>
          <li>
            <a href="#">FAQ</a>
          </li>
          <li>
            <a href="#">How to</a>
          </li>
          <li>
            <a href="#">Features</a>
          </li>
          <li>
            <a href="#">Baggage</a>
          </li>
          <li>
            <a href="#"> Route Map</a>
          </li>
          <li>
            <a href="#">Our Communities</a>
          </li>
        </div>
        <div data-aos="fade-up" data-aos-duration='2500' className="footerLinks">
          <span className="linkTitle">Information</span>
          <li>
            <a href="#">Chauffeur</a>
          </li>
          <li>
            <a href="#">Distination</a>
          </li>
          <li>
            <a href="#">Careers</a>
          </li>
          <li>
            <a href="#">Transportation</a>
          </li>
          <li>
            <a href="#">Programme Rules</a>
          </li>
        </div>

      </div>
    </div>
  )
}

export default Footer

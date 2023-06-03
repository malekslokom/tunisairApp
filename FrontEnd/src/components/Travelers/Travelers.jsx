import React,{useEffect} from 'react'

import paris from '../../assets/images/paris.jpg' 
import london from '../../assets/images/london.jpg' 
import newyork from '../../assets/images/NewYork.jpg' 
import traveler4 from '../../assets/images/traveler4.jpg'
import dubai from '../../assets/images/dubai.jpg' 

import traveler1 from '../../assets/images/traveler1.jpeg'
import traveler2 from '../../assets/images/traveler2.jpg'
import traveler3 from '../../assets/images/traveler3.jpg'
import Aos from 'aos'
import 'aos/dist/aos.css'
const travelers = [
  {
    id:1,
    destinationImage: paris,
    travelerImage: traveler1,
    travelerName:"Lucy Hall",
    socialLink:"@lucyhall"
  },
  {
    id:2,
    destinationImage: newyork,
    travelerImage: traveler2,
    travelerName:"Mark Thenos",
    socialLink:"@markth9"
  },
  {
    id:3,
    destinationImage: london,
    travelerImage: traveler3,
    travelerName:"Alex Quin",
    socialLink:"@alexyy"
  },
  {
    id:4,
    destinationImage: dubai,
    travelerImage: traveler4,
    travelerName:"Ahmed Malik",
    socialLink:"@amedmalik7"
  }
]
const Travelers = () => {
  // useEffect to set animation effect
  useEffect(()=>{
    Aos.init({duration: 2000})
  }, [])
  return (
      <div className="travelers container section">
        <div data-aos="fade-down" data-aos-duration='2500' className="sectionContainer">
          <h2>
            Top travelers of this month!
          </h2>

          <div className="travelersContainer grid">
            {travelers.map((t)=> {
              {/* Single Passenger Card */}
              return(
                <div data-aos="fade-up" data-aos-duration='2500' key ={t.id} className="singleTraveler">
                <img src={t.destinationImage} className='destinationImage' />
                <div className="travelerDetails">
                  <div className="travelerPicture">
                    <img src={t.travelerImage} className='travelerImage'/>
                  </div>
                  <div className="travelerName">
                    <span>{t.travelerName}</span>
                    <p>{t.socialLink}</p>
                  </div>
                </div>
              </div>
              );
            })
          }
          </div>
        </div>
      </div>
  )
}

export default Travelers

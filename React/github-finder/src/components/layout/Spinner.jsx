import React from 'react'
import spinnergif from "./assets/spinner.gif"

const Spinner = () => {
  return (
	<div className='w-100 mt-20'>
			<img src={spinnergif} className='text-center mx-auto' width={180} alt='로딩...' />
	</div>
  )
}

export default Spinner
/* eslint-disable react/prop-types */
import React from "react";
import '../../css/LinkWithIcon.css'

const LinkWithIcon = ({ title, link, emoji }) => {
  return (
	<a href={link} className='align_center'>
		{title} <img src={emoji} alt='' className='link_emoji'/>
	</a>
	);
};

export default LinkWithIcon;

import React, { useContext } from "react";
import { ThemeContext } from "../context/ThemeContext";
import "./ThemeSelector.css"
import modeIcon from '../assets/mode-icon(1).svg';

const themeColors = ["#58249c", "#249c6b", "#b70233"];

const ThemeSelector = () => {
    const { changeColor, changeMode, mode } = useContext(ThemeContext);

	const toggleMode = () => {
		changeMode(mode === 'dark' ? 'light' : 'dark');
		console.log(mode);
	}

    return (
        <div className="theme-selector">
			<div className="mode-toggle">
				<img src={modeIcon} onClick={toggleMode} alt="다크/라이트 활성화 버튼"/>
			</div>
            <div className="theme-buttons">
                {themeColors.map((color) => (
                    <div key={color} onClick={() => changeColor(color)} style={{ background: color }} />
                ))}
            </div>
        </div>
    );
};

export default ThemeSelector;

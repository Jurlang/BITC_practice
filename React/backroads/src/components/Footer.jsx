import { pageLinks, socialLinks } from "../data";

const Footer = () => {
    const date = (new Date().getFullYear());

    return (
        <div>
            <footer className="section footer">
                <ul className="footer-links">
                    {pageLinks.map((link) => {
                        return (
                            <li key={link.id}>
                                <a href={link.href} className="footer-link">
                                    {link.text}
                                </a>
                            </li>
                        );
                    })}
                </ul>
                <ul className="footer-icons">
                    {socialLinks.map((icon) => {
                        return (
                            <li key={icon.id}>
                                <a href={icon.href} target="_blank" className="footer-icon">
                                    <i className={icon.icon}></i>
                                </a>
                            </li>
                        );
                    })}
                </ul>
                <p className="copyright">
                    copyright &copy; Backroads travel tours company
                    <span id="date">{date}</span> all rights reserved
                </p>
            </footer>
        </div>
    );
};

export default Footer;

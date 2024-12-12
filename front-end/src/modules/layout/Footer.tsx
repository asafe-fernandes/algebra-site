import LinkText from '@comp/actions/LinkText';
import styles from './Footer.module.css';

export default function Footer({theme}: {theme?: 'dark' | 'light'}){
  return(
    <footer className={`${styles.footerContainer} ${theme && styles[theme]}`}>
      <p>Apenas um <LinkText hreflang='pt-br' href="/">Teste</LinkText></p>
    </footer>
  );
}
import LinkText from '@comp/actions/LinkText';
import styles from './Footer.module.css';
import LinkButton from '@comp/actions/LinkButton';
import Article from '@cont/Article';

export default function Footer(){
  return(
    <footer className={styles.footerContainer}>
      <ul className={styles.listAnchorContainer}>
        <li><LinkText hreflang='pt-br' href='/Coliseu'>Coliseu</LinkText></li>
        <li><LinkText hreflang='pt-br' href='/Arena'>Arena</LinkText></li>
        <li><LinkText hreflang='pt-br' href='/Entrar'>Entrar</LinkText></li>
        <li><LinkText hreflang='pt-br' href='/Coliseu/Ranking'>Ranking</LinkText></li>
      </ul>
      <LinkButton hreflang='pt-br' href='/Coliseu'>Resolver Desafios</LinkButton>
      <Article>
        <p className='p_small'>© MatHub | 2024<br />Todos os direitos reservados</p>
        <ul className={styles.listAnchorContainer}>
          <li><LinkText hreflang='pt-br' href='/Termos'>Termos de Uso</LinkText></li>
          <li><LinkText hreflang='pt-br' href='/Politicas'>Políticas de Privacidade</LinkText></li>
          <li><LinkText hreflang='pt-br' href='/Politicas/#cookies'>Cookies</LinkText></li>
        </ul>
      </Article>
    </footer>
  );
}
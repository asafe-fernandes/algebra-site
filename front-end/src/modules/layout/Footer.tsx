import LinkText from '@comp/actions/LinkText';
import styles from './Footer.module.css';
import LinkButton from '@comp/actions/LinkButton';
import Article from '@cont/Article';

export default function Footer({theme}: {theme?: 'dark' | 'light'}){
  return(
    <footer className={`${styles.footerContainer} ${theme && styles[theme]}`}>
      <ul className={styles.listAnchorContainer}>
        <li><LinkText hreflang='pt-br' href='/questions'>Questões</LinkText></li>
        <li><LinkText hreflang='pt-br' href='/login'>Login</LinkText></li>
        <li><LinkText hreflang='pt-br' href='/questions/ranking'>Ranking</LinkText></li>
        <li><LinkText hreflang='pt-br' href='/settings'>Configurações</LinkText></li>
      </ul>
      <LinkButton hreflang='pt-br' href='/questions'>Exercícios</LinkButton>
      <Article>
        <p className='p_small'>© MatHub | 2024<br />Todos os direitos reservados</p>
        <ul className={styles.listAnchorContainer}>
          <li><LinkText hreflang='pt-br' href='/terms'>Termos de Uso</LinkText></li>
          <li><LinkText hreflang='pt-br' href='/policy'>Políticas de Privacidade</LinkText></li>
          <li><LinkText hreflang='pt-br' href='/policy/#cookies'>Cookies</LinkText></li>
        </ul>
      </Article>
    </footer>
  );
}
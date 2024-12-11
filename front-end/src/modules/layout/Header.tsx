import Logo from '@comp/icons/Logo';
import styles from './Header.module.css';
import LinkIcon from '@comp/actions/LinkIcon';
import { BsPlayFill } from 'react-icons/bs';

export default function Header(){
  return (
    <header className={styles.headerContainer}>
      <LinkIcon href='/'><Logo /></LinkIcon>
      <h5>Animação texto</h5>
      <h5>Animação texto</h5>
      <LinkIcon href='/login'><BsPlayFill /></LinkIcon>
    </header>
  );
}
import LinkButton from '@comp/actions/LinkButton';
import styles from './not-found.module.css';
import { BsArrowReturnLeft } from 'react-icons/bs';

export default function NotFound() {
  return (
    <section className={styles.sectionContainer}>
      <h1>Página não encontrada!<br/><strong>[404]</strong></h1>
      <LinkButton href="/">Voltar <BsArrowReturnLeft /></LinkButton>
    </section>
  );
}
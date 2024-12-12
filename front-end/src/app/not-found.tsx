'use client';

import styles from './not-found.module.css';
import { BsArrowReturnLeft } from 'react-icons/bs';
import Button from '@comp/actions/Button';
import { useRouter } from 'next/navigation';

export default function NotFound() {
  const router = useRouter();
  return (
    <section className={styles.sectionContainer}>
      <h1>Página não encontrada!<br/><strong>[404]</strong></h1>
      <Button onClick={() => router.back()}>Voltar <BsArrowReturnLeft /></Button>
    </section>
  );
}
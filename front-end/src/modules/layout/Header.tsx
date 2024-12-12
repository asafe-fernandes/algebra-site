'use client';

import Logo from '@comp/icons/Logo';
import styles from './Header.module.css';
import LinkIcon from '@comp/actions/LinkIcon';
import { BsPlayFill } from 'react-icons/bs';
import SliderText from '@comp/text/SliderText';

export default function Header({theme}: {theme?: 'dark' | 'light'}){
  const slideText = ['Matriz', 'Lógica Matemática', 'Sistemas de Numeração'];
  return (
    <header className={`${styles.headerContainer} ${theme && styles[theme]}`}>
      <LinkIcon hreflang='pt-br' href='/' ><Logo /></LinkIcon>
      <SliderText timer={5} texts={slideText} animation='top'/>
      <LinkIcon hreflang='pt-br' href='/login'><BsPlayFill /></LinkIcon>
    </header>
  );
}
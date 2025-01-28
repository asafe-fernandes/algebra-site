'use client';

import Logo from '@comp/icons/Logo';
import styles from './Header.module.css';
import LinkIcon from '@comp/actions/LinkIcon';
import { BsFlag, BsMoon, BsPlayFill, BsSun } from 'react-icons/bs';
import SliderText from '@comp/text/SliderText';
import ButtonIcon from '@comp/actions/ButtonIcon';
import { Dispatch, SetStateAction, useEffect, useState } from 'react';
import { getCookie, setCookie } from '@assets/cookies';
import Breadcrumbs from '@mod/link/Breadcrumbs';

export default function Header({theme, onChangeTheme}: {theme?: 'dark' | 'light', onChangeTheme?: Dispatch<SetStateAction<string>>}){
  const slideText = ['Matriz', 'Lógica Matemática', 'Sistemas de Numeração'];
  const [newTheme, setNewTheme] = useState<string>('light');

  const changeTheme = () => {
    const savedTheme = newTheme === 'light' ? 'dark' : 'light';
    setNewTheme(savedTheme);
    setCookie('theme', savedTheme, 30);
    if(onChangeTheme) onChangeTheme(savedTheme);
  };
  
  useEffect(() => {
    const cookiesTheme = getCookie('theme', document);
    if(cookiesTheme) {
      setNewTheme(cookiesTheme);
      if(onChangeTheme) onChangeTheme(cookiesTheme);
    }
  }, [onChangeTheme]);

  return (
    <div className={styles.fixedHeaderContainer}>
      <Breadcrumbs />
      <header className={`${styles.headerContainer} ${theme && styles[theme]}`}>
        <div className={styles.flowIconContainer}> 
          <LinkIcon hreflang='pt-br' href='/' ><Logo /></LinkIcon>
          <LinkIcon hreflang='pt-br' href='/Arena' ><BsFlag /> </LinkIcon>
        </div>

        <SliderText timer={5} texts={slideText} animation='top'/>

        <div className={styles.flowIconContainer}>
          <ButtonIcon onClick={changeTheme}>{newTheme === 'light' ? <BsSun /> : <BsMoon />}</ButtonIcon>
          <LinkIcon hreflang='pt-br' href='/Entrar'><BsPlayFill /></LinkIcon>
        </div>
      </header>
    </div>
  );
}
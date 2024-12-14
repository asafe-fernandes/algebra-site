'use client';

import Logo from '@comp/icons/Logo';
import styles from './Header.module.css';
import LinkIcon from '@comp/actions/LinkIcon';
import { BsMoon, BsPlayFill, BsSun } from 'react-icons/bs';
import SliderText from '@comp/text/SliderText';
import ButtonIcon from '@comp/actions/ButtonIcon';
import { Dispatch, SetStateAction, useEffect, useState } from 'react';
import { getCookie, setCookie } from '@assets/cookies';

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
      <header className={`${styles.headerContainer} ${theme && styles[theme]}`}>
        <LinkIcon hreflang='pt-br' href='/' ><Logo /></LinkIcon>
        <SliderText timer={5} texts={slideText} animation='top'/>
        <div className={styles.flowIconContainer}>
          {!theme && <ButtonIcon onClick={changeTheme}>{newTheme === 'light' ? <BsSun /> : <BsMoon />}</ButtonIcon>}
          <LinkIcon hreflang='pt-br' href='/login'><BsPlayFill /></LinkIcon>
        </div>
      </header>
    </div>
  );
}
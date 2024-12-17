'use client';

import Header from '@mod/layout/Header';
import Footer from '@mod/layout/Footer';
import styles from './page.module.css';
import { useState } from 'react';
import Theme from '@cont/Theme';
import LoginForm from '@mod/form/LoginForm';
import Section from '@cont/Section';

export default function Login(){
  const [theme, setTheme] = useState<string>('light');
  return(
    <Theme theme={theme == 'light' || theme == 'dark' ? theme : undefined}>
      <Header onChangeTheme={setTheme}/>
      <main className={styles.mainContainer}>
        <Section>
          <LoginForm />
        </Section>
      </main>
      <Footer />
    </Theme>
  );
}
import styles from './Theme.module.css';

export default function Theme({children, theme}: {children: React.ReactNode, theme?: 'dark' | 'light'}){
  return(
    <div className={`${styles.themeContainer} ${theme && styles[theme]}`}>{children}</div>
  );
}
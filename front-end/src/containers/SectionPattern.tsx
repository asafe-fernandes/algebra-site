import styles from './SectionPattern.module.css';

export default function SectionPattern({children}: {children?: React.ReactNode}){
  return(
    <div className={styles.backgroundContainer}>
      <section className={styles.sectionContainer}>
        {children}
      </section>
    </div>
  );
}
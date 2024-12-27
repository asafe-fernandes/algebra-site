import styles from './Section.module.css';

export default function Section({children, className}: {children?: React.ReactNode, className?: string}){
  return(
    <section className={`${styles.sectionContainer} ${className}`}>
      {children}
    </section>
  );
}
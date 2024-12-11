import Link, { LinkProps } from 'next/link';
import styles from './LinkIcon.module.css';

type TypeLinkIcon = LinkProps & {
  children: React.ReactNode
}

export default function LinkIcon({children, ...props}: TypeLinkIcon){
  return(
    <Link className={styles.linkIconContainer} {...props}>{children}</Link>
  );
} 
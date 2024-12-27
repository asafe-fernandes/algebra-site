import Link, { LinkProps } from 'next/link';
import styles from './LinkButton.module.css';

type TypeLinkButton = LinkProps & {
  children: React.ReactNode
  target?: string
  hreflang?: string
  rel?: string
  detach?: boolean
}

export default function LinkButton({children, target, hreflang, rel, detach, ...props}: TypeLinkButton){
  return(
    <Link target={target} rel={rel} hrefLang={hreflang} className={`${styles.linkContainerButton} ${detach && styles.detach}`} {...props}>
      {children}
    </Link>
  );
}
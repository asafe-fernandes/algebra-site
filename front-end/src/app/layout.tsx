import './globals.css';
import styles from './layout.module.css';

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-br">
      <title>MatHub</title>
      <body className={styles.layoutContainer} suppressHydrationWarning={true}>
        {children}
      </body>
    </html>
  );
}

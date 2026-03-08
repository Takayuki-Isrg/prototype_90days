# パッケージ、ライブラリのインポート
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


# URL、認証情報
URL = "https://the-internet.herokuapp.com/login" # ログインページのURL
USERNAME = "tomsmith" # ユーザー名
PASSWORD = "SuperSecretPassword!" # パスワード


def main():
    # opts = Options()
    # opts.add_argument("-headless")  # まずは表示ありで
    driver = webdriver.Firefox(options = Options())

    try:
        driver.set_window_size(1280, 900)
        wait = WebDriverWait(driver, 10)

        # 1) ログインページを開く
        driver.get(URL)

        # 2) 入力（表示されるまで待つ）
        wait.until(EC.visibility_of_element_located((By.ID, "username"))).send_keys(USERNAME)
        wait.until(EC.visibility_of_element_located((By.ID, "password"))).send_keys(PASSWORD)

        # 3) ログイン押下（クリック可能まで待つ）
        wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, 'button[type="submit"]'))).click()

        # 4) 成功メッセージ確認（flash）
        flash = wait.until(EC.visibility_of_element_located((By.ID, "flash"))).text
        print("FLASH:", flash.strip())
        assert "You logged into a secure area!" in flash

        # 5) ログアウト
        wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, 'a[href="/logout"]'))).click()

        # 6) ログアウトメッセージ確認
        flash2 = wait.until(EC.visibility_of_element_located((By.ID, "flash"))).text
        print("FLASH:", flash2.strip())
        assert "You logged out of the secure area!" in flash2

        input("成功！Enterで終了...")

    finally:
        driver.quit()


if __name__ == "__main__":
    main()

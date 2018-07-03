from tests import marks
from tests.base_test_case import SingleDeviceTestCase
from views.sign_in_view import SignInView


@marks.dapps
class TestUsingDApps(SingleDeviceTestCase):

    @marks.testrail_id(1396)
    def test_open_google_com_via_open_dapp(self):
        sign_in_view = SignInView(self.driver)
        home = sign_in_view.create_user()
        start_new_chat = home.plus_button.click()
        start_new_chat.open_d_app_button.click()
        start_new_chat.enter_url_editbox.set_value('google.com')
        start_new_chat.confirm()
        browsing_view = start_new_chat.get_base_web_view()
        browsing_view.wait_for_d_aap_to_load()
        assert browsing_view.element_by_text('Google').is_element_displayed()

    @marks.testrail_id(1397)
    def test_back_forward_buttons_browsing_website(self):
        sign_in = SignInView(self.driver)
        home = sign_in.create_user()
        start_new_chat = home.plus_button.click()
        start_new_chat.open_d_app_button.click()
        start_new_chat.enter_url_editbox.set_value('www.wikipedia.org')
        start_new_chat.confirm()
        browsing_view = start_new_chat.get_base_web_view()
        browsing_view.wait_for_d_aap_to_load()

        browsing_view.element_by_text_part('Русский', 'button').click()
        browsing_view.find_text_part('Избранная статья')
        browsing_view.browser_previous_page_button.click()
        browsing_view.find_text_part('English', 15)

        browsing_view.browser_next_page_button.click()
        browsing_view.find_text_part('Избранная статья')
        browsing_view.back_to_home_button.click()

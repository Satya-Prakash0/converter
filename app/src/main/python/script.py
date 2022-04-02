from googletrans import Translator

def main():

    translator = Translator()

    textt='Tumhare bina abb mann nahi lata kya tum'
    translations = translator.translate(textt, dest='te')
    return translations.text




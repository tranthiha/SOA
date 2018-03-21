module Librarian::BookManagement::CreateHelper
  def process
    create_book

    generate_status
  end

  def create_book
    Book.create(@params)
  end

  def generate_status
    @status = {
      :code => Settings.code.success,
      :message => "",
      :data    => ,
    }
  end
end

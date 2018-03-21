module Librarian::BookManagement::CreateHelper
  def process

  end

  def generate_status
    @status = {
      :code => Settings.code.success,
      :message => "",
      :data    => ,
    }
  end
end

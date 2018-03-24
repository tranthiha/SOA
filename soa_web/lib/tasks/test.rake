namespace :test do
  task get_student_books: :environment do
    require 'net/http'
    require 'uri'

    uri = URI.parse("http://localhost:3000/api/v1/student/books")
    response = Net::HTTP.get_response(uri)
    puts response.body
  end
end

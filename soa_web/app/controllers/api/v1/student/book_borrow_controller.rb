class Api::V1::BookBorrowController < ApplicationController
  before_action :authenticate_request!
  skip_before_action :verify_authenticity_token
  before_action -> {pre_processing}

  include Student::BookBorrow::BookBorrowHelper

  def create
    render json: @action.status
  end

  def index
    render json: @action.status
  end

  def destroy
    render json: @action.status
  end
end
